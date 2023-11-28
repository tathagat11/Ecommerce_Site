//package com.academia6_3.ESDProject.Students;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//
//public class StudentsConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            StudentsRepository repository) {
//        return args -> {
//            Students tathagat = new Students(
//                    189,
//                    "Tathagata",
//                    "Talukdar",
//                    "tathagata.talukdar@gmail.com",
//                    "url/1",
//                    2.8F,
//                    28,
//                    2025,
//                    "CSE",
//                    "AIML",
//                    69L,
//                    "changeme"
//            );
//            Students alex = new Students(
//                    179,
//                    "Alex",
//                    "Ayyup",
//                    "alex.ayyup@gmail.com",
//                    "url/2",
//                    3.9F,
//                    20,
//                    2025,
//                    "CSE",
//                    "Networking",
//                    420L,
//                    "changeme"
//            );
//            Students student3 = new Students(
//                    173,
//                    "Paul",
//                    "Walker",
//                    "paul.walker@gmail.com",
//                    "url/3",
//                    3.6F,
//                    23,
//                    2025,
//                    "ECE",
//                    "VLSI",
//                    109L,
//                    "changeme"
//            );
//            Students student4 = new Students(
//                    166,
//                    "Lionel",
//                    "Messi",
//                    "lionel.messi@gmail.com",
//                    "url/4",
//                    3.4F,
//                    25,
//                    2025,
//                    "ECE",
//                    "VLSI",
//                    110L,
//                    "changeme"
//            );
//            Students student5 = new Students(
//                    123,
//                    "Cristiano",
//                    "Ronaldo",
//                    "cristiano.ronaldo@gmail.com",
//                    "url/5",
//                    3.1F,
//                    24,
//                    2025,
//                    "ECE",
//                    "Digital Design",
//                    109L,
//                    "changeme"
//            );
//            repository.saveAll(
//                    List.of(tathagat, alex, student3, student4, student5)
//            );
//        };
//    }
//}
