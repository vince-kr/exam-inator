package examinator.manager.interact;

import examinator.manager.ExamManagement;

public interface Interaction {
    /*
    Each Interaction class must implement the transmitAndReceive method which is called as
    part of the complete request response cycle. It takes an ExamManagement object, so the
    method body can get and set fields of the object. It returns a String reference to the
    next interaction that should be called.
     */
    String transmitAndReceive(ExamManagement exMan);
}