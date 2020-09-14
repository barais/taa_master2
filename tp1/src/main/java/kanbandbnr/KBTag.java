package kanbandbnr;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class KBTag {

	private Long id;

	private String label;

	private List<KBCard> cards;
	
	public void addCards(KBCard card) {
		this.cards.add(card);
	}

	@ManyToMany
	public List<KBCard> getCards() {
		return cards;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setCards(List<KBCard> cards) {
		this.cards = cards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
