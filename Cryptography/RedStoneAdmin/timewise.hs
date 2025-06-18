-- $ runhaskell magic.hs
-- Output: 35979253760252124533044326983738660434153

module Main where

n = 0x10000000000000000000000000000000055

secret = 0 -- forgotten, find it!

a x 0 = x
a x c = a (x + 1 - (x + 1) `div` n * n) (c - 1)

m x 0 = 0
m x 1 = x
m x c = a x (m x (c - 1))

e x 0 = 1
e x 1 = x
e x c = m x (e x (c - 1))

main = print $ e secret 31337