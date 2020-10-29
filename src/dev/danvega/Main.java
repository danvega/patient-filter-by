package dev.danvega;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Patient 1
	    Patient jasmin = new Patient("6e71c6e5-9533-46cb-825d-ddf3f9478653", "Jasmin","jasmin@gmail.com");
	    jasmin.setSamples( List.of(new Sample(Time.MORNING,0.89),new Sample(Time.AFTERNOON,0.32)) );

	    // Patient 2
	    Patient natasha = new Patient("8608148d-d9e6-4e73-92de-6672b37e628f","Natasha","natasha@gmail.com");
	    natasha.setSamples(List.of(new Sample(Time.MORNING,0.44),new Sample(Time.AFTERNOON,0.19),new Sample(Time.EVENING,0.28)));

		System.out.println("Patients --------------------------------------------------------------");
	    List<Patient> patients = List.of(jasmin,natasha);
        System.out.println(patients);

		System.out.println("Filtered Patients -----------------------------------------------------");
		Predicate<Sample> afternoon = sample -> sample.getTime().equals(Time.AFTERNOON) && sample.getValue() < 0.20;
		Predicate<Sample> evening = sample -> sample.getTime().equals(Time.EVENING) && sample.getValue() > 0.25;

		var results = patients.stream()
				.filter(patient -> patient.getSamples().stream().filter(afternoon).count() > 0)
				.filter(patient -> patient.getSamples().stream().filter(evening).count() > 0)
				.collect(Collectors.toList());
		System.out.println(results);

    }
}
