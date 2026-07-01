import SwiftUI
import Shared

@main
struct iOSApp: App {
    init(){
        KoinInitializerWrapper.shared.doInitKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}