package org.alex.hw18.dao.impl;

import org.alex.hw18.dao.ParticipantDao;
import org.alex.hw18.domain.Level;
import org.alex.hw18.domain.Participant;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ParticipantDaoImpl implements ParticipantDao {

    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant participant1 = new Participant();
        participant1.setId(1);
        participant1.setName("John");
        participant1.setEmail("john@email.com");
        participant1.setPrimarySkill("Maths");
        participant1.setLevel(Level.L2);

        Participant participant2 = new Participant();
        participant2.setId(2);
        participant2.setName("McCoy");
        participant2.setEmail("mccoy@email.com");
        participant2.setPrimarySkill("Geometry");
        participant2.setLevel(Level.L1);

        Participant participant3 = new Participant();
        participant3.setId(3);
        participant3.setName("Alex");
        participant3.setEmail("alex@email.com");
        participant3.setPrimarySkill("Java");
        participant3.setLevel(Level.L1);

        Participant participant4 = new Participant();
        participant4.setId(4);
        participant4.setName("Dimitry");
        participant4.setEmail("dimm@email.com");
        participant4.setPrimarySkill("JS");
        participant4.setLevel(Level.L3);

        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
        participants.add(participant4);

    }

    @Override
    public List<Participant> findAllParticipants() {
        return participants;
    }

    @Override
    public Participant findOne(int id) {
        return participants.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Participant participant) {
        Participant participantToUpdate = null;

        if (participant.getId() != null) {
            participantToUpdate = findOne(participant.getId());
            int participantIndex = participants.indexOf(participantToUpdate);
            participantToUpdate.setName(participant.getName());
            participantToUpdate.setEmail(participant.getEmail());
            participantToUpdate.setLevel(participant.getLevel());
            participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
            participants.set(participantIndex, participantToUpdate);
        } else {
            // save
            participant.setId(participants.size()+1);
            participants.add(participant);
        }
    }

    @Override
    public void delete(int id) {
        Iterator<Participant> iter = participants.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
            }
        }
    }
}
