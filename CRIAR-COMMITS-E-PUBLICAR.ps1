$ErrorActionPreference = 'Stop'

Write-Host 'Laboratorio 02 - Git: commits por exercicio' -ForegroundColor Cyan

if (-not (Get-Command git -ErrorAction SilentlyContinue)) {
    throw 'Git nao foi encontrado. Instale o Git for Windows e volte a executar este script.'
}

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $root

if (-not (git config user.name)) {
    $gitName = Read-Host 'Nome para os commits Git'
    git config user.name $gitName
}
if (-not (git config user.email)) {
    $gitEmail = Read-Host 'Email associado aos commits (pode ser o email GitHub)'
    git config user.email $gitEmail
}

if (-not (Test-Path '.git')) {
    git init
}

# Commit inicial: estrutura e documentacao geral.
git add README.md .gitignore CRIAR-COMMITS-E-PUBLICAR.ps1
git commit -m "docs: add repository overview and setup instructions"

# Um commit real por exercicio.
git add Exercicio-1-Activities
git commit -m "feat(exercicio-1): add Android Activity projects"

git add Exercicio-2-Services
git commit -m "feat(exercicio-2): add started Service and shared counter"

git add Exercicio-3-Broadcast-Receivers
git commit -m "feat(exercicio-3): add phone state broadcast receiver"

git add Exercicio-4-Bloco-de-Notas
git commit -m "feat(exercicio-4): add simple notes application"

git add Memorando
git commit -m "docs: add laboratory memorandum"

Write-Host "`nCommits criados:" -ForegroundColor Green
git --no-pager log --oneline -6

$remote = Read-Host "`nCole o URL HTTPS do repositorio GitHub vazio (Enter para publicar mais tarde)"
if (-not [string]::IsNullOrWhiteSpace($remote)) {
    $existingRemote = git remote get-url origin 2>$null
    if ($LASTEXITCODE -eq 0) {
        git remote set-url origin $remote
    } else {
        git remote add origin $remote
    }
    git branch -M main
    git push -u origin main
    Write-Host "Repositorio publicado no GitHub." -ForegroundColor Green
} else {
    Write-Host "Commits guardados localmente. Para publicar depois:" -ForegroundColor Yellow
    Write-Host 'git remote add origin https://github.com/SEU-UTILIZADOR/Lab02-Componentes-Android.git'
    Write-Host 'git branch -M main'
    Write-Host 'git push -u origin main'
}
