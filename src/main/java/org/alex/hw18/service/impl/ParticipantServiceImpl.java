package org.alex.hw18.service.impl;

import org.alex.hw18.dao.ParticipantDao;
import org.alex.hw18.dao.impl.ParticipantDaoImpl;
import org.alex.hw18.domain.Participant;
import org.alex.hw18.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl  implements ParticipantService {

    @Autowired
    ParticipantDao participantDao;


    @Override
    public List<Participant> findAllParticipants() {
        return participantDao.findAllParticipants();
    }

    @Override
    public Participant findOne(int id) {
        return participantDao.findOne(id);
    }

    @Override
    public void save(Participant participant) {
        participantDao.save(participant);
    }

    @Override
    public void delete(int id) {
        participantDao.delete(id);
    }
}
