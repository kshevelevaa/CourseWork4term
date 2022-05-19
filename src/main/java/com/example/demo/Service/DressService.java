package com.example.demo.Service;

import com.example.demo.Entity.Dress;
import com.example.demo.Entity.User;
import com.example.demo.Repository.DressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class DressService {

    @Autowired
    UserService userService;

    @Autowired
    DressRepo dressRepo;

    @Transactional
    public void plusCountDress(User user, int dressNumber) {
        Dress dress;
        if (user.getDressCount(dressNumber) == 0) {
            dress = new Dress(user, dressNumber);
            addDress(dress, user);
        } else {
            dress = user.getDress(dressNumber);
            dress.setDressCount(dress.getDressCount() + 1);
        }

        dressRepo.save(dress);
    }

    @Transactional
    public void minusCountDress(User user, int dressNumber) {
        Dress dress = user.getDress(dressNumber);
        switch (user.getDressCount(dressNumber)) {
            case 0:
                return;
            case 1: {
                deleteDressfromUser(dress, user);
                break;
            }
            default: {
                dress.setDressCount(dress.getDressCount() - 1);
                dressRepo.save(dress);
            }
        }
    }

    public void addDress(Dress dress, User user) {
        user.getList().add(dress);
        saveDress(dress);
    }

    @Transactional
    public void deleteDressfromUser(Dress dress, User user) {
        user.getList().remove(dress);
        userService.resaveUser(user);
        deleteDress(dress);
    }

    @Transactional
    public void saveDress(Dress dress) {
        dressRepo.save(dress);
    }


    @Transactional
    public void deleteDress(Dress dress) {
        dressRepo.deleteById(dress.getId());
    }

    @Transactional
    public void deleteDresses(Set<Dress> dressSet) {
        dressRepo.deleteAll(dressSet);
    }

    @Transactional
    public List<Dress> GetDress(Set<Dress> dressSet) {
        return dressRepo.findAll();
    }
}
