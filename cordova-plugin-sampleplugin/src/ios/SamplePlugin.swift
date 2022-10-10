import Foundation

@objc(SamplePlugin)
class SamplePlugin : CDVPlugin
{
    override
    func pluginInitialize() {
    }
    
    @objc(func1:)
    func func1(command: CDVInvokedUrlCommand)
    {
        NSLog("func1 called")
        guard let arg0 = command.arguments[0] as? Int, let arg1 = command.arguments[1] as? String, let arg2 = command.arguments[2] as? [Int] else {
            NSLog("Parameter invalid")
            let pluginResult:CDVPluginResult = CDVPluginResult(status:CDVCommandStatus_ERROR, messageAs: "Parameter Invalid")
            self.commandDelegate.send(pluginResult, callbackId:command.callbackId)
            return
        }

        let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: ["arg0": arg0, "arg1": arg1, "arg2": arg2] )
        commandDelegate.send(pluginResult, callbackId: command.callbackId)
    }

    @objc(func2:)
    func func2(command: CDVInvokedUrlCommand)
    {
        NSLog("func2 called")
        guard let arg0 = command.arguments[0] as? String else {
            NSLog("Parameter invalid")
            let pluginResult:CDVPluginResult = CDVPluginResult(status:CDVCommandStatus_ERROR, messageAs: "Parameter Invalid")
            self.commandDelegate.send(pluginResult, callbackId:command.callbackId)
            return
        }
        
        if arg0 == "int" {
            let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: 1234)
            commandDelegate.send(pluginResult, callbackId: command.callbackId)
        }else if arg0 == "string" {
            let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: "Hello World")
            commandDelegate.send(pluginResult, callbackId: command.callbackId)
        }else if arg0 == "array" {
            var output_array:[Int] = []
            for i in 1 ..< 5 {
                output_array.append(i)
            }
            let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: output_array)
            commandDelegate.send(pluginResult, callbackId: command.callbackId)
        }else{
            let pluginResult = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: "Invalid arg0")
            commandDelegate.send(pluginResult, callbackId: command.callbackId)
            return
        }
        return
    }
}
