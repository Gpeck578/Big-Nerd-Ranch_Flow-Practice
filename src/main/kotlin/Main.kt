package org.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private const val BASE_URL = "http://kotlin-book.bignerdranch.com/2e"
private const val FLIGHT_ENDPOINT = "$BASE_URL/flight"
private const val LOYALTY_ENDPOINT = "$BASE_URL/loyalty"

val bannedPassengers = setOf("Nogartse")

suspend fun fetchFlight(
    passengerName: String,
    start: Long
): FlightStatus = coroutineScope {
    val client = HttpClient(CIO)

    val flightResponse = async {
        println("Started fetching flight info: ${System.currentTimeMillis() - start}")
        client.get<String>(FLIGHT_ENDPOINT).also {
            println("Finished fetching flight info: ${System.currentTimeMillis() - start}")
        }
    }

    val loyaltyResponse = async {
        println("Started fetching loyalty info: ${System.currentTimeMillis() - start}")
        client.get<String>(LOYALTY_ENDPOINT).also {
            println("Finished fetching loyalty info: ${System.currentTimeMillis() - start}")
        }
    }
    delay(500)
    println("Combining flight data: ${System.currentTimeMillis() - start}")

    FlightStatus.parse(
        passengerName = passengerName,
        flightResponse = flightResponse.await(),
        loyaltyResponse = loyaltyResponse.await()
    )
}

suspend fun watchFlight(
    initialFlight: FlightStatus,
    start: Long
) {
    val passengerName = initialFlight.passengerName
    val currentFlight: Flow<FlightStatus> = flow {
        require(passengerName !in bannedPassengers) {
            "Cannot track $passengerName's flight. They are banned from the airport."
        }

        var flight = initialFlight
        while (flight.departureTimeInMinutes >= 0 && !flight.isFlightCanceled) {
            emit(flight)
            delay(1000)
            flight = flight.copy(
                departureTimeInMinutes = flight.departureTimeInMinutes - 1
            )
        }
    }

    currentFlight
        .map { flight ->
            when (flight.boardingStatus) {
                BoardingState.FlightCanceled -> "Your flight was canceled"
                BoardingState.BoardingNotStarted -> "Boarding will start soon"
                BoardingState.WaitingToBoard -> "Other passengers are boarding"
                BoardingState.Boarding -> "You can now board the plane"
                BoardingState.BoardingEnded -> "The boarding doors have closed"
            } + " (Flight departs in ${flight.departureTimeInMinutes} minutes)"
        }
        .onCompletion {
            println("Finished tracking $passengerName's flight: ${System.currentTimeMillis() - start}")
        }
        .collect { status ->
            println("$passengerName: $status: ${System.currentTimeMillis() - start}")
        }
}

suspend fun fetchFlights(
    passengerNames: List<String> = listOf("Madrigal", "Polarcubis"),
    start: Long
) = passengerNames.map { fetchFlight(it, start) }

fun main() {
    val start = System.currentTimeMillis()

    runBlocking {
        println("Getting the latest flight info...: ${System.currentTimeMillis() - start}")
        val flights = fetchFlights(start = start)
        val flightDescriptions = flights.joinToString {
            "${it.passengerName} (${it.flightNumber})"
        }
        println("Found flights for $flightDescriptions: ${System.currentTimeMillis() - start}")
        val flightsAtGate = MutableStateFlow(flights.size)
        launch {
            flightsAtGate
                .takeWhile { it > 0 }
                .onCompletion {
                    println("Finished tracking all flights: ${System.currentTimeMillis() - start}")
                }
                .collect { flightCount ->
                    println("There are $flightCount flights being tracked: ${System.currentTimeMillis() - start}")
                }
            println("Finished tracking all flights: ${System.currentTimeMillis() - start}")
        }

        launch {
            flights.forEach {
                watchFlight(it, start)
                flightsAtGate.value -= 1
            }
        }
    }
}