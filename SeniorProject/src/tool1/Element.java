package tool1;

/**
 * @author Ugur Ozkan
 * 
 */
public class Element {

	private String tag, type, id, name;

	public Element(String tag, String type, String id, String name) {
		setTag(tag);
		setType(type);
		setId(id);
		setName(name);
	}

	private void setTag(String tag) {
		if (tag != null && !tag.isEmpty())
			this.tag = tag;
		else
			this.tag = null;
	}

	private void setType(String type) {
		if (type != null && !type.isEmpty())
			this.type = type;
		else
			this.type = null;
	}

	private void setId(String id) {
		if (id != null && !id.isEmpty())
			this.id = id;
		else
			this.id = null;
	}

	private void setName(String name) {
		if (name != null && !name.isEmpty())
			this.name = name;
		else
			this.name = null;
	}

	public String getTag() {
		return tag;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		switch (getTag().toLowerCase()) {
		case "button":
			return processButtonTag();
		case "select":
			return processSelectTag();
		case "input":
			return processInputTag();
		default:
			return null;
		}
	}

	private String processButtonTag() {
		switch (getType().toLowerCase()) {
		case "submit":
			return "clickAndWait_with_" + processBy();
		default:
			return null;
		}
	}

	private String processSelectTag() {
		switch (getType().toLowerCase()) {
		case "select-one":
			return "select_with_" + processBy();
		default:
			return null;
		}
	}

	private String processInputTag() {
		switch (getType().toLowerCase()) {
		case "text":
			return "type_with_" + processBy();
		case "radio":
			return "click_with_" + processBy();
		case "checkbox":
			return "click_with_" + processBy();
		default:
			return null;
		}
	}

	private String processBy() {
		if (getId() != null)
			return "id=" + id;
		else
			return "name=" + name;
	}

}