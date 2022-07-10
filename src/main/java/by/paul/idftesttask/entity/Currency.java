package by.paul.idftesttask.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "currencies")
public class Currency {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "symbol")
  private String symbol;
  @Column(name = "name")
  private String name;
  @Column(name = "price_usd")
  private Double price_usd;

}
