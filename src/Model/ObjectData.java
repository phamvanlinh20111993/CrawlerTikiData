package Model;

public class ObjectData {
	
	private Object key;
	
	private Object value;
	
	public ObjectData() {}
	
	/**
	 * @param key
	 * @param value
	 */
	public ObjectData(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectData [key=" + key.toString() + ", value=" + value.toString() + "]";
	}
}
