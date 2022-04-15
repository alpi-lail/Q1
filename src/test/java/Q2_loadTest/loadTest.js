import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 10,
    duration: '30s',
};

export default function () {
  const url = 'https://reqres.in/api/register';
  const payload = JSON.stringify({
    email: 'eve.holt@reqres.in',
    password: 'pistol',
  });

  let res = http.get(url);

  check(res, {
    'status is 200': (r) => r.status === 200,
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  http.post(url, payload, params);
}

