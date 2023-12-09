package TaskBarchynaiIakubova.demo.requests;

public record TaskRequest(
        String title,
        String description,
        Boolean completed
) {
}
