package additional_task;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "House")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHouse;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int flatsAmount;

    @OneToMany(mappedBy = "house", orphanRemoval = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE})
    private Set<Person> personSet;

    public House(String address, int flatsAmount) {
        this.address = address;
        this.flatsAmount = flatsAmount;
    }

    public House() {
    }

    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFlatsAmount() {
        return flatsAmount;
    }

    public void setFlatsAmount(int flatsAmount) {
        this.flatsAmount = flatsAmount;
    }

}
