package by.itransition.fanfic.dao.impl;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.search.bridge.StringBridge;

public class CollectionToCSVBridge implements StringBridge {

	@Override
	public String objectToString(Object value) {
		if (value instanceof Collection) {
			StringBuffer buf = new StringBuffer();
			Collection<?> col = (Collection<?>)value;
			Iterator<?> it = col.iterator();
			while (it.hasNext()) {
				String next = it.next().toString();
				buf.append(next);
				if (it.hasNext()) {
					buf.append(", ");
				}
			}
			return buf.toString();
		} else {
			if (null != value) {
				return value.toString();
			}
		}
		return null;
	}

}