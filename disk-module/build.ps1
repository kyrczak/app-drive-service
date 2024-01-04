function main() {
    $title = (Get-Content Dockerfile | Select-String "org.opencontainers.image.title").ToString().Split('=')[1].Trim(); Write-Host $title
    $version = (Get-Content Dockerfile | Select-String "org.opencontainers.image.version").ToString().Split('=')[1].Trim(); Write-Host $version
    docker build `
        --label "org.opencontainers.image.created=$(Get-Date -Format o)" `
        --label "org.opencontainers.image.title=$title" `
        --label "org.opencontainers.image.version=$version" `
        -t "${title}:${version}" .
}

main