## Flows
- Setting Up a Flow
- MutableStateFlow
- Flow Termination
- Flow Transformations
- Error Handling in Flows
- For the More Curious: SharedFlow

  ```
"C:\Program Files\Java\jdk-11\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.4\lib\idea_rt.jar=54563:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.4\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\G$\IdeaProjects\untitled2\build\classes\kotlin\main;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib\1.9.22\d6c44cd08d8f3f9bece8101216dbe6553365c6e3\kotlin-stdlib-1.9.22.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-client-cio-jvm\1.6.8\10363273ce0953360132909e3bc8b2157cf52c2e\ktor-client-cio-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-client-core-jvm\1.6.8\352729af42d3d636113ee3b9e20849e2e9948d18\ktor-client-core-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlinx\kotlinx-coroutines-core-jvm\1.6.0\f3b8fd26c2e76d2f18cbc36aacb6e349fcb9fd5f\kotlinx-coroutines-core-jvm-1.6.0.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.jetbrains\annotations\13.0\919f0dfe192fb4e063e7dacadee7f8bb9a2672a9\annotations-13.0.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk7\1.8.0\3c91271347f678c239607abb676d4032a7898427\kotlin-stdlib-jdk7-1.8.0.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\1.7.36\6c62681a2f655b49963a5983b8b0950a6120ae14\slf4j-api-1.7.36.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk8\1.8.0\ed04f49e186a116753ad70d34f0ac2925d1d8020\kotlin-stdlib-jdk8-1.8.0.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-http-cio-jvm\1.6.8\2fa9098b5b19cccb933661fbf39aff0da5de0f4f\ktor-http-cio-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-network-tls-jvm\1.6.8\b43ccf4d05e4d6c32bc05e34367570ee7a38fad7\ktor-network-tls-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-http-jvm\1.6.8\12c9387eccddfe67756f57591449c8ad9d3ba4e2\ktor-http-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-network-jvm\1.6.8\1da789f6b279e63a6960f362a7264f81de885d9f\ktor-network-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-utils-jvm\1.6.8\4f2c2961d533e1ba5db727d873909bda65b376b3\ktor-utils-jvm-1.6.8.jar;C:\Users\G$\.gradle\caches\modules-2\files-2.1\io.ktor\ktor-io-jvm\1.6.8\a1369405da6c12293c59afea6f4a1ae7e56d2398\ktor-io-jvm-1.6.8.jar org.example.MainKt
Getting the latest flight info...: 89
Started fetching flight info: 259
Started fetching loyalty info: 316
Combining flight data: 766
Finished fetching loyalty info: 4253
Finished fetching flight info: 7197
Started fetching flight info: 7199
Started fetching loyalty info: 7200
Combining flight data: 7708
Finished fetching loyalty info: 9247
Finished fetching flight info: 12245
Found flights for Madrigal (NW8274), Polarcubis (JW9131): 12277
There are 2 flights being tracked: 12291
Finished tracking Madrigal's flight: 12300
Polarcubis: You can now board the plane (Flight departs in 28 minutes): 12307
There are 1 flights being tracked: 12315
Polarcubis: You can now board the plane (Flight departs in 27 minutes): 13315
Polarcubis: You can now board the plane (Flight departs in 26 minutes): 14326
Polarcubis: You can now board the plane (Flight departs in 25 minutes): 15329
Polarcubis: You can now board the plane (Flight departs in 24 minutes): 16344
Polarcubis: You can now board the plane (Flight departs in 23 minutes): 17357
Polarcubis: You can now board the plane (Flight departs in 22 minutes): 18363
Polarcubis: You can now board the plane (Flight departs in 21 minutes): 19373
Polarcubis: You can now board the plane (Flight departs in 20 minutes): 20384
Polarcubis: You can now board the plane (Flight departs in 19 minutes): 21393
Polarcubis: You can now board the plane (Flight departs in 18 minutes): 22405
Polarcubis: You can now board the plane (Flight departs in 17 minutes): 23415
Polarcubis: You can now board the plane (Flight departs in 16 minutes): 24429
Polarcubis: You can now board the plane (Flight departs in 15 minutes): 25440
Polarcubis: The boarding doors have closed (Flight departs in 14 minutes): 26450
Polarcubis: The boarding doors have closed (Flight departs in 13 minutes): 27462
Polarcubis: The boarding doors have closed (Flight departs in 12 minutes): 28477
Polarcubis: The boarding doors have closed (Flight departs in 11 minutes): 29490
Polarcubis: The boarding doors have closed (Flight departs in 10 minutes): 30503
Polarcubis: The boarding doors have closed (Flight departs in 9 minutes): 31515
Polarcubis: The boarding doors have closed (Flight departs in 8 minutes): 32524
Polarcubis: The boarding doors have closed (Flight departs in 7 minutes): 33533
Polarcubis: The boarding doors have closed (Flight departs in 6 minutes): 34545
Polarcubis: The boarding doors have closed (Flight departs in 5 minutes): 35559
Polarcubis: The boarding doors have closed (Flight departs in 4 minutes): 36561
Polarcubis: The boarding doors have closed (Flight departs in 3 minutes): 37569
Polarcubis: The boarding doors have closed (Flight departs in 2 minutes): 38578
Polarcubis: The boarding doors have closed (Flight departs in 1 minutes): 39588
Polarcubis: The boarding doors have closed (Flight departs in 0 minutes): 40598
Finished tracking Polarcubis's flight: 41607
Finished tracking all flights: 41608
Finished tracking all flights: 41608

Process finished with exit code 0
```
