#AdminControl.startServer("server1","M1072317Node01")

AdminApp.installInteractive("C:\Users\c010098\Documents\wsadminlib\AutoDeploy\dist\AdderEAR.ear")
AdminApp.install()
AdminConfig.setSaveMode('rollbackOnConflict')
validations = AdminConfig.validate()
print '=== validations ===>',validations
AdminConfig.save()

appName = 'AdderEAR'
AppMgr = AdminControl.queryNames( 'name=ApplicationManager,*' )
AdminControl.invoke( AppMgr, 'startApplication', appName)

bean=AdminControl.queryNames('name=%s,type=Application,*' % appName)
print '=== bean ===>',bean