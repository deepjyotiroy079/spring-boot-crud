package live.deepjyotiroy.springapp.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
//    private List<Topic> topicsList = new ArrayList<>();
    @Autowired
    private TopicRepository topicRepository;

    // getting all the topics
    public List<Topic> getAll() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    // getting topic by id
    public Topic getTopicByID(Long id) {
        Optional<Topic> op_topic = topicRepository.findById(id);
        return op_topic.get(); // getting the object from the optional<>
    }

    // posting a new topic
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, long id) {
        topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
