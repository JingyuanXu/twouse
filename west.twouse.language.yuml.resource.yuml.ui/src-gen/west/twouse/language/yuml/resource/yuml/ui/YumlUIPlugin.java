/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package west.twouse.language.yuml.resource.yuml.ui;

/**
 * A singleton class for the text resource UI plug-in.
 */
public class YumlUIPlugin extends org.eclipse.ui.plugin.AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "west.twouse.language.yuml.resource.yuml.ui";
	public static final String EMFTEXT_SDK_VERSION = "1.3.2";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	
	private static YumlUIPlugin plugin;
	
	public YumlUIPlugin() {
		super();
	}
	
	public void start(org.osgi.framework.BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	public void stop(org.osgi.framework.BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static YumlUIPlugin getDefault() {
		return plugin;
	}
	
	public static void showErrorDialog(final String title, final String message) {
		org.eclipse.swt.widgets.Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				org.eclipse.swt.widgets.Shell parent = new org.eclipse.swt.widgets.Shell();
				org.eclipse.jface.dialogs.MessageDialog dialog = new org.eclipse.jface.dialogs.MessageDialog(parent, title, null, message, org.eclipse.jface.dialogs.MessageDialog.ERROR,
				new String[] { org.eclipse.jface.dialogs.IDialogConstants.OK_LABEL }, 0) {
				};
				dialog.open();
			}
		});
	}
	/**
	 * Helper method for error logging.
	 * 
	 * @param message the error message to log
	 * @param exception the exception that describes the error in detail
	 * 
	 * @return the status object describing the error
	 */
	public static org.eclipse.core.runtime.IStatus logError(String message, Throwable exception) {
		org.eclipse.core.runtime.IStatus status;
		if (exception != null) {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, YumlUIPlugin.PLUGIN_ID, 0, message, exception);
		} else {
			status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, YumlUIPlugin.PLUGIN_ID, message);
		}
		final YumlUIPlugin pluginInstance = YumlUIPlugin.getDefault();
		if (pluginInstance == null) {
			System.err.println(message);
			if (exception != null) {
				exception.printStackTrace();
			}
		} else {
			pluginInstance.getLog().log(status);
		}
		return status;
	}
}
