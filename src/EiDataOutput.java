class EiDataOutput extends EiRequest {
    public EiDataOutput(String requestHead, EiRequest parent) {
        this.requestHead = requestHead;
        this.parent = parent;
    }

    public void transmit() {
        System.out.println(requestHead);
    }

    public EiRequest getNext() {
        return parent;
    }
}
