package enums;

public enum StatusCode {

    CODE_200(200),
    CODE_404(404),
    CODE_201(201);

    public final int count;

    StatusCode(int count) {
        this.count = count;
    }
}
