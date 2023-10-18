import java.util.regex.Pattern;

class EiDataInput extends EiRequest {
    public EiDataInput(
            String requestHead,
            String prompt,
            String parent,
            Pattern pattern) {
        this.requestHead = requestHead;
        this.prompt = prompt;
        this.parent = parent;
        this.pattern = pattern;
    }
}
