package live.deepjyotiroy.springapp.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topicsList = new ArrayList<>();

    // getting all the topics
    public List<Topic> getAll() {
        return topicsList;
    }

    // getting topic by id
    public Topic getTopicByID(long id) {
        Topic topic = new Topic();
        for(Topic t: topicsList) {
            if(t.getId() == id) {
                topic.setId(t.getId());
                topic.setName(t.getName());
                topic.setDescription(t.getDescription());
            }
        }
        return topic;
    }

    // posting a new topic
    public void addTopic(Topic topic) {
        topicsList.add(topic);
    }

    public void updateTopic(Topic topic, long id) {
        for(int i=0; i<topicsList.size(); ++i) {
            Topic t = topicsList.get(i);
            if(t.getId() == id) {
                topicsList.set(i, topic);
            }
        }
    }

    public void deleteTopic(long id) {
        topicsList.removeIf(topic -> topic.getId() == id);
    }
}
