package org.alex.hw18.service;

import org.alex.hw18.domain.Participant;

import java.util.List;

public interface ParticipantService {

    public List<Participant> findAllParticipants();
    public Participant findOne(int id);
    public void save(Participant participant);
    public void delete(int id);
}
