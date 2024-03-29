/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package west.twouse.language.owl2fs.resource.owl2fs.util;

/**
 * A utility class that can be used to work with EObjects. While many similar
 * methods are provided by EMF's own EcoreUtil class, the missing ones are
 * collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class Owl2fsEObjectUtil {
	
	public static <T> java.util.Collection<T> getObjectsByType(java.util.Iterator<?> iterator,
	org.eclipse.emf.ecore.EClassifier type) {
		java.util.Collection<T> result = new java.util.ArrayList<T>();
		while (iterator.hasNext()) {
			java.lang.Object object = iterator.next();
			if (type.isInstance(object)) {
				@SuppressWarnings("unchecked")				
				T t = (T) object;
				result.add(t);
			}
		}
		return result;
	}
	
	public static org.eclipse.emf.ecore.EObject findRootContainer(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}
	
	public static java.lang.Object invokeOperation(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EOperation o) {
		java.lang.reflect.Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				java.lang.Object result = method.invoke(element, new java.lang.Object[]{});
				return result;
			}
		} catch (SecurityException e) {
			west.twouse.language.owl2fs.resource.owl2fs.mopp.Owl2fsPlugin.logError("java.lang.Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			west.twouse.language.owl2fs.resource.owl2fs.mopp.Owl2fsPlugin.logError("java.lang.Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			west.twouse.language.owl2fs.resource.owl2fs.mopp.Owl2fsPlugin.logError("java.lang.Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			west.twouse.language.owl2fs.resource.owl2fs.mopp.Owl2fsPlugin.logError("java.lang.Exception while matching proxy URI.", e);
		} catch (java.lang.reflect.InvocationTargetException e) {
			west.twouse.language.owl2fs.resource.owl2fs.mopp.Owl2fsPlugin.logError("java.lang.Exception while matching proxy URI.", e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")	
	public static void setFeature(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EStructuralFeature eFeature, java.lang.Object value, boolean clearIfList) {
		int upperBound = eFeature.getUpperBound();
		if (upperBound > 1 || upperBound < 0) {
			Object oldValue = object.eGet(eFeature);
			if (oldValue instanceof java.util.List<?>) {
				java.util.List<java.lang.Object> list = (java.util.List<java.lang.Object>) oldValue;
				if (clearIfList) {
					list.clear();
				}
				list.add(value);
			} else {
				assert false;
			}
		} else {
			object.eSet(eFeature, value);
		}
	}
	
}
