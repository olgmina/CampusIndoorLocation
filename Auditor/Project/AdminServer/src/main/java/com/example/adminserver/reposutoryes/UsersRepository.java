package com.example.adminserver.reposutoryes;

import com.example.adminserver.models.Organizational;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UsersRepository extends JpaRepositoryImplementation <Organizational,Long> {
}
