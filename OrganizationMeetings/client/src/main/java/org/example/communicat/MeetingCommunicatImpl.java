package org.example.communicat;

import org.example.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class MeetingCommunicatImpl implements MeetingCommunicat{
    @Autowired
    RestTemplate restTemplate;
//    @Value("${serverURL}")
    public final String serverUrl = "http://localhost:8080/api/meeting";

    public MeetingCommunicatImpl() {

    }

    @Override
    public List<Meeting> listMeeting() {
        ResponseEntity<List<Meeting>> responseEntity =
                restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>() {
                });
        return responseEntity.getBody();
    }

    @Override
    public Meeting getMeeting(int id) {
        Meeting meeting = restTemplate.getForObject(serverUrl + "/" + id, Meeting.class);
        return meeting;
    }

    @Override
    public void addMeeting(Meeting meeting) {

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(serverUrl, meeting, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Override
    public void deleteMeeting(int id) {
        restTemplate.delete(serverUrl + "/" + id);
    }
}
