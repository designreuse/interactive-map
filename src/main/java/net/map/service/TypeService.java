package net.map.service;

import net.map.domain.Category;
import net.map.domain.Type;
import net.map.repository.CategoryRepository;
import net.map.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TypeService {
    private TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }

    public Iterable<Type> list() {
        return typeRepository.findAll();
    }

    public Type findOne(long id) {
        return typeRepository.findOneById(id);
    }

    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public void delete(Type type) {
        typeRepository.delete(type);
    }
}
