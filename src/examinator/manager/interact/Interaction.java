package examinator.manager.interact;

import examinator.manager.ExamManagement;

public interface Interaction {
    String transmitAndReceive(ExamManagement exMan);
}