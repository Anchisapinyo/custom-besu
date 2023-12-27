rm -rf config/extra_data_for_qbft_genesis.txt

docker run -it --rm \
  -v $(pwd)/config/:/inventory/ \
  hyperledger/besu:latest \
  rlp encode --from=/inventory/qbft_extra_data.json \
   --to=/inventory/extra_data_for_qbft_genesis.txt \
   --type=QBFT_EXTRA_DATA