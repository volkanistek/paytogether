package com.paytogether.service;

import com.paytogether.entity.Activity;
import com.paytogether.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }

    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity update(Long id, Activity activityDetails) {
        return activityRepository.findById(id).map(activity -> {
            activity.setTitle(activityDetails.getTitle());
            activity.setDescription(activityDetails.getDescription());
            return activityRepository.save(activity);
        }).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
    }

    public void deleteById(Long id) {
        activityRepository.deleteById(id);
    }
}