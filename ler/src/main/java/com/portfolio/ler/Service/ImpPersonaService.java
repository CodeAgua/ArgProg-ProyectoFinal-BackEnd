package com.portfolio.ler.Service;

import com.portfolio.ler.Entity.Persona;
import com.portfolio.ler.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService{
    @Autowired IPersonaRepository ipersonaRepo;
    
     public List<Persona> list(){
         return ipersonaRepo.findAll();
     }
     
     public Optional<Persona> getOne(int id){
         return ipersonaRepo.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return ipersonaRepo.findByNombre(nombre);
     }
     
     public void save(Persona pers){
         ipersonaRepo.save(pers);
     }
     
     public void delete(int id){
         ipersonaRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ipersonaRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ipersonaRepo.existsByNombre(nombre);
     }
}
