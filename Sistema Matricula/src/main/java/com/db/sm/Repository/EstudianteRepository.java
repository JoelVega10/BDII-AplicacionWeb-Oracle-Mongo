package com.db.sm.Repository;

import com.db.sm.Model.EstudianteMongo;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<EstudianteMongo,String>{
    @Override
    public void delete(EstudianteMongo estudianteMongo);
}
