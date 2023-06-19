package com.noraroc.mef.model.service;

import com.noraroc.mef.model.dao.TramiteRepository;
import com.noraroc.mef.model.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteService {

    @Autowired
    private TramiteRepository tramiteRepository;

    public List<Tramite> search(Tramite tramite){
        return tramiteRepository.buscarPorParametros(tramite.getId(), tramite.getCodigo(), tramite.getNombre(),
                tramite.getNumeroComprobante(), tramite.getResumen(), tramite.getMonto());
    }

    public Tramite save(Tramite tramite) {
        return tramiteRepository.save(tramite);
    }

    public List<Tramite> saveAll(List<Tramite> tramiteList) {
        return tramiteRepository.saveAll(tramiteList);
    }

    public List<Tramite> findAll() {
        return tramiteRepository.findAll();
    }
}
