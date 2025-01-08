package com.example.testpgr3.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.testpgr3.entity.Complaint;
import com.example.testpgr3.entity.User;
import com.example.testpgr3.exception.ResourceNotFoundException;
import com.example.testpgr3.repository.ComplaintRepository;
import com.example.testpgr3.repository.UserRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(ComplaintService.class);

    public Complaint saveComplaint(Complaint complaint) {
        logger.info("Saving complaint for user: {}", getLoggedInUsername());
        User user = getLoggedInUser();
        complaint.setUser(user);
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        logger.info("Fetching all complaints");
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByLoggedInUser() {
        User user = getLoggedInUser();
        logger.info("Fetching complaints for user: {}", user.getUsername());
        return complaintRepository.findByUser(user);
    }

    public Complaint getComplaintById(long id) {
        logger.info("Fetching complaint by ID: {}", id);
        return complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint", "Id", id));
    }

    public Complaint updateComplaint(Complaint complaint, long id) {
        Complaint existingComplaint = complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint", "Id", id));
        BeanUtils.copyProperties(complaint, existingComplaint, "id", "user");
        return complaintRepository.save(existingComplaint);
    }

    private User getLoggedInUser() {
        String username = getLoggedInUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

    private String getLoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else if ("anonymousUser".equals(principal)) {
            throw new IllegalStateException("User must be logged in to perform this action.");
        } else {
            return principal.toString();
        }
    }
}
