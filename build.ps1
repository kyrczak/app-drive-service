function main() {
    Set-Location ./disk-module/; ./build.ps1; Set-Location ..
    Set-Location ./application-module/; ./build.ps1; Set-Location ..
    Set-Location ./gateway/; ./build.ps1; Set-Location ..
    Set-Location ./angular-module/; ./build.ps1; Set-Location ..  
}

main