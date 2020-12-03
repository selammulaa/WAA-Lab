package miu.edu.lab9.exception;


public class EmployeeException extends RuntimeException {

    private static final long serialVersionUID = 9060751397339719682L;
    private String id;
    private String message = "Employee Not Found for this email address: ";

    public EmployeeException() {
    }

    public EmployeeException(String id, String message) {
        this.id = id;

        if (message != null) this.message = message;

    }

    public String getFullMessage() {
        return (message + id);
    }

    public String getEmployeeId() {
        return id;
    }

    @Override
    public String getLocalizedMessage() {
        // TODO Auto-generated method stub
        return super.getLocalizedMessage();
    }


}
