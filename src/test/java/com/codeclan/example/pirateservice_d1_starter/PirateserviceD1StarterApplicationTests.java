package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createSinglePirateAndShip(){
		Ship ship = new Ship("Black Pearl");
		shipRepository.save(ship);

		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate);
	}

	@Test
	public void canCreateRaid() {
		Ship ship = new Ship("Queen Anne's Revenge");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Edward", "Teach", 32, ship);
		pirateRepository.save(pirate1);

		Raid raid1 = new Raid("Bute", 1000);
		raidRepository.save(raid1);

		raid1.addPirate(pirate1);
		raidRepository.save(raid1);
	}
}
