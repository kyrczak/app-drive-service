function main() {
    [System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Users\patko\.jdks\temurin-17.0.8.1")
    [System.Environment]::SetEnvironmentVariable("Path", [System.Environment]::GetEnvironmentVariable('Path', [System.EnvironmentVariableTarget]::Machine) + ";$($env:JAVA_HOME)\bin")

    .\mvnw clean verify -DskipTests

    $title = (Get-Content Dockerfile | Select-String "org.opencontainers.image.title").ToString().Split('=')[1].Trim()
    Write-Host $title

    $version = (Get-Content Dockerfile | Select-String "org.opencontainers.image.version").ToString().Split('=')[1].Trim()
    Write-Host $version

    $imageTag = "${title}:${version}"
    $imageTag = $imageTag -replace '"', ''  # Remove double quotes from the tag
    Write-Host "Image Tag: $imageTag"

    docker build `
        --label "org.opencontainers.image.created=$(Get-Date -Format o)" `
        --label "org.opencontainers.image.title=$title" `
        --label "org.opencontainers.image.version=$version" `
        -t $imageTag .
}

main