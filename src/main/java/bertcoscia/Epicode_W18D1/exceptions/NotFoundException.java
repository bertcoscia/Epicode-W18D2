package bertcoscia.Epicode_W18D1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Could not find record with id " + id);
    }
}
