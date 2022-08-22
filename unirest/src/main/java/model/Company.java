package model;

import java.util.Objects;

public class Company {

    public String name;
    public String catchPhrase;
    public String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "{" +
                " bs:'" + bs + '\'' +
                ",catchPhrase:'" + catchPhrase + '\'' +
                ",name:'" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name)
                && Objects.equals(catchPhrase, company.catchPhrase)
                && Objects.equals(bs, company.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catchPhrase, bs);
    }
}
