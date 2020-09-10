package kanbandbnr;

import java.util.Calendar;
import java.util.List;

public class Card {

	private String label;

	private String description;

	private Calendar dueDate;

	private User assignedUser;

	private int estimatedTimeMinutes;

	private List<Tag> tags;

	private String url;

	private List<Comment> comments;

}
