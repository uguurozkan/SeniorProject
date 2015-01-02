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
		String result = null;
		if ((result = getMethodRepresentation()) != null)
			return normalize(result);
		else 
			return null;
	}

	private String normalize(String s) {
		return s.replaceAll("[^\\w]", "_");
	}

	public String getMethodRepresentation() {
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
		String result = null;
		switch (getType().toLowerCase()) {
		case "submit":
			if ((result = processBy()) != null)
				return "clickAndWait_" + result;
		default:
			return result;
		}
	}

	private String processSelectTag() {
		String result = null;
		switch (getType().toLowerCase()) {
		case "select-one":
			if ((result = processBy()) != null)
				return "select_" + result;
		default:
			return result;
		}
	}

	private String processInputTag() {
		String result = null;
		switch (getType().toLowerCase()) {
		case "text":
			if ((result = processBy()) != null)
				return "type_" + result;
		case "radio":
			if ((result = processBy()) != null)
				return "click_" + result;
		case "checkbox":
			if ((result = processBy()) != null)
				return "click_" + result;
		default:
			return result;
		}
	}

	private String processBy() {
		if (getId() != null)
			return "id_" + id;
		else if (getName() != null)
			return "name_" + name;
		else
			return null;
	}

}
