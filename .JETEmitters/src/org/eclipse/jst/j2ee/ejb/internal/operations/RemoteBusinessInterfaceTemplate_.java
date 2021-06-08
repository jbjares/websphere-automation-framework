package org.eclipse.jst.j2ee.ejb.internal.operations;

public class RemoteBusinessInterfaceTemplate_
{
  protected static String nl;
  public static synchronized RemoteBusinessInterfaceTemplate_ create(String lineSeparator)
  {
    nl = lineSeparator;
    RemoteBusinessInterfaceTemplate_ result = new RemoteBusinessInterfaceTemplate_();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + "import javax.ejb.Remote;" + NL + "" + NL + "@Remote" + NL + "public interface ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     CreateSessionBeanTemplateModel model = (CreateSessionBeanTemplateModel) argument; 
    
	if (model.getBusinessInterfaceJavaPackageName() != null && model.getBusinessInterfaceJavaPackageName().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(model.getBusinessInterfaceJavaPackageName());
    stringBuffer.append(TEXT_2);
    
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(model.getBusinessInterfaceClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
