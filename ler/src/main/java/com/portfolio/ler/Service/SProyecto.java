package com.portfolio.ler.Service;

import com.portfolio.ler.Entity.Proyecto;
import com.portfolio.ler.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class SProyecto {
    @Autowired
    RProyecto rproy ;
    
    public List<Proyecto> list(){
         return rproy.findAll();
     }
    
    public Optional<Proyecto> getOne(int id){
         return rproy.findById(id);
     }
     
     public Optional<Proyecto> getByTituloP(String tituloP){
         return rproy.findByTituloP(tituloP);
     }
     
     public void save(Proyecto proy){
         rproy.save(proy);
     }
     
     public void delete(int id){
         rproy.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rproy.existsById(id);
     }
     
     public boolean existsByTituloP(String tituloP){
         return rproy.existsByTituloP(tituloP);
     }
}
