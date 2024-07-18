package Spring.SpringCrudApi.handle;

public class ErrorResponse extends RuntimeException{
    private String message;
    private int status;
    private long timestamp;

    public ErrorResponse( int status,String message) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
