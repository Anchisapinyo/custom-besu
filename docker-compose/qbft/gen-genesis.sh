rm -rf config/genesis.json

docker run -it --rm \
  -v $(pwd)/config/:/inventory \
  hyperledger/besu:latest \
  operator generate-blockchain-config \
    --config-file=/inventory/template_qbft_genesis.json \
    --to=/inventory/test

cp config/test/genesis.json config/genesis.json

rm -rf config/test