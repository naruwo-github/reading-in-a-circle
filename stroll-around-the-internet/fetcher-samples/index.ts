const createUrlWithParams = (url: string, params: Record<string, string>) => {
    const searchParams = new URLSearchParams(params)
    return url + '?' + searchParams.toString()
}

const url = 'http://localhost/'

const params = {
    user: 'user',
    userId: '100',
    size: 'large'
}

console.log(createUrlWithParams(url, params))
