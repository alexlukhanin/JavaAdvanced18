package org.alex.hw18.dao;

import org.alex.hw18.domain.Participant;

import java.util.List;

public interface ParticipantDao {

    public List<Participant> findAllParticipants();
    public Participant findOne(int id);
    public void save(Participant participant);
    public void delete(int id);


}
